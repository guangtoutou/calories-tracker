import axios from 'axios';

export default {
	user:{
		login: credentials =>
			axios.post('http://localhost:8080/login',credentials)
			.then(res => res.headers['authorization']),
		signup: userform =>
			axios.post('http://localhost:8080/register',userform)
			.then(res => res.data)
	}
};