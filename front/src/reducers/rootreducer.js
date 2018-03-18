const initialState = {
	user:{}
};


const rootReducer = (state = initialState, action) => {
	switch (action.type) {
		case 'USER_LOGGED_IN':
			return {user:{token:action.token}};
		case 'USER_LOGGED_OUT':
			return {user:{}};
		case 'USER_SIGNUP':
			return {user:{token:action.token}};
		default:
			return state;
	}
};

export default rootReducer;
