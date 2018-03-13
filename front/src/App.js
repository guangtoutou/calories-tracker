import React from 'react';
import {Route} from 'react-router-dom';
import HomePage from './components/pages/homepage';
import LoginPage from './components/pages/loginpage';
import DashBoard from './components/pages/dashboard';

const App = ()=>(
	<div className='ui container'>
		<Route path='/' exact component={HomePage}/>
		<Route path='/login' exact component={LoginPage}/>
		<Route path='/dashboard' exact component={DashBoard}/>
		
	</div>
);

export default App;