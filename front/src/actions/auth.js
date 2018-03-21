import api from '../api';

export const userLoggedIn = token => ({
	type: 'USER_LOGGED_IN',
	token
});

export const userLoggedOut = () => ({
	type: 'USER_LOGGED_OUT'
});

export const userSignup = user => ({
	type: 'USER_SIGNUP',
	user
});

export const login = credentials => dispatch => 
	api.user.login(credentials).then(token=>{
		localStorage.jwt = token;
		dispatch(userLoggedIn(token));
	});

export const logout = credentials => dispatch => {
	localStorage.removeItem('jwt');
	dispatch(userLoggedOut());
}

export const signup = data => dispatch => 
	api.user.signup(data).then(user=>{
		localStorage.jwt = user.token;
		dispatch(userSignup(user));
	});
	