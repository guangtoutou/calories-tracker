import App from './app';
import {BrowserRouter} from 'react-router-dom';
import 'semantic-ui-css/semantic.min.css';
import {Provider} from 'react-redux';
import {createStore, applyMiddleware} from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import rootReducer from './reducers/rootreducer';
import thunk from 'redux-thunk';

const store = createStore(
	rootReducer,
	composeWithDevTools(applyMiddleware(thunk))
);


ReactDOM.render(
	<BrowserRouter>
		<Provider store={store}>
			<App/>
		</Provider>
	</BrowserRouter>,
	document.getElementById('root')
);