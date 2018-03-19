import React from 'react';
import { Link } from 'react-router-dom';
import SignupForm from '../forms/SignupForm';
import { connect } from 'react-redux';
import { signup } from '../../actions/auth';


class SignupPage extends React.Component {
	submit = data =>
		this.props.signup(data).then(
			() => this.props.history.push('/dashboard')
		);

	render() {
		return (
			<div>
				<h1>Signup Page</h1>
				<SignupForm submit={this.submit} />
			</div>
		);
	}
}

export default connect(null, { signup })(SignupPage);