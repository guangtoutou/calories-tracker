import {Route} from 'react-router-dom';
import HomePage from './components/pages/homepage';
import LoginPage from './components/pages/loginpage';
import {connect} from 'react-redux';

const App = ({ location, isAuthenticated })=>(
	<div className='ui container'>
		<Route path='/' exact component={HomePage}/>
		<Route path='/login' exact component={LoginPage}/>
	</div>
);

export default App;