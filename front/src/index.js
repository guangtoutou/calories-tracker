import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import {BrowserRouter} from 'react-router-dom';
import 'semantic-ui-css/semantic.min.css';
import {Provider} from 'react-redux';
import {createStore, applyMiddleware} from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import rootReducer from './reducers/rootreducer';
import thunk from 'redux-thunk';
import { userLoggedIn } from './actions/auth';

const store = createStore(
	rootReducer,
	composeWithDevTools(applyMiddleware(thunk))
);

if(localStorage.jwt){
	const user = {token: localStorage.jwt};
	store.dispatch(userLoggedIn(user));
}

ReactDOM.render(
	<BrowserRouter>
		<Provider store={store}>
			<App/>
		</Provider>
	</BrowserRouter>,
	document.getElementById('root')
);