import React from 'react';
import {Route} from 'react-router-dom';
import HomePage from './components/pages/homepage';
import LoginPage from './components/pages/loginpage';
import DashBoard from './components/pages/dashboard';
import SignupPage from './components/pages/SignupPage';
import UserRoute from './components/routes/UserRoute';
import GuestRoute from './components/routes/GuestRoute';


const App = ()=>(
	<div className='ui container'>
		<Route path='/' exact component={HomePage}/>
		<GuestRoute path='/login' exact component={LoginPage}/>
		<GuestRoute path='/signup' exact component={SignupPage}/>
		<UserRoute path='/dashboard' exact component={DashBoard}/>
		
	</div>
);

export default App;