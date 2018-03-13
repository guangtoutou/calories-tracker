const initialState = {
	user:{}
};


const rootReducer = (state = initialState, action) => {
	switch (action.type) {
		case 'USER_LOGGED_IN':
			return {user:{token:action.token}};
		case 'USER_LOGGED_OUT':
			return {user:{}};
		default:
			return state;
	}
};

export default rootReducer;
