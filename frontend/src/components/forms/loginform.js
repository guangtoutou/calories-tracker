import { Form, Button } from 'semantic-ui-react';
import Validator from 'validator';
import InlineError from '../messages/InlineError';

class LoginForm extends React.Component {

	constructor(props) {
		super(props);
		this.state = {
			email: '',
			password: '',
			loading: false,
			errors: {}
		};
	}

	handleChange(e) {
		this.setState({
			...this.state, [e.target.name]: e.target.value
		});
	}

	handleSubmit(e) {
		const errors = this.validate(this.state);
		this.setState({ errors });
		var email = this.state.email;
		var password = this.state.password;
		if (Object.keys(errors).length === 0) {
			setTimeout(this.setState({ 'loading': true }), 3000);
			this.props.submit({ 'username':email, password });
		}
	}

	validate(data) {
		const errors = {};
		if (!Validator.isEmail(data.email)) errors.email = 'Invalid email';
		if (Validator.isEmpty(data.password)) errors.password = 'password is empty';
		return errors;
	}

	render() {
		const data = this.state;
		return (
			<Form onSubmit={(e) => this.handleSubmit(e)} loading={data.loading}>
				<Form.Field error={!!data.errors.email}>
					<label htmlFor='email'>Email</label>
					<input
						type='text'
						id='email'
						name='email'
						placeholder='example@example.com'
						value={this.state.email}
						onChange={(e) => this.handleChange(e)}
					/>
					{data.errors.email && <InlineError text={data.errors.email} />}
				</Form.Field>
				<Form.Field error={!!data.errors.password}>
					<label htmlFor='password'>Password</label>
					<input
						type='password'
						id='password'
						name='password'
						value={this.state.password}
						onChange={(e) => this.handleChange(e)}
					/>
					{data.errors.password && <InlineError text={data.errors.password} />}
				</Form.Field>
				<Button primary>Login</Button>
			</Form>
		);
	}
}

export default LoginForm;