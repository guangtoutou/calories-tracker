import React from 'react';
import {Link} from 'react-router-dom';
import {connect} from 'react-redux';
import {logout} from '../../actions/auth';

const homepage = ({isAuthenticated, logout})=>(
	<div>
		<h1>Home Page</h1>
		{isAuthenticated? 
			<button onClick={()=>logout()}>Logout</button>
			: <div>
				<Link to='/login'>Login </Link>
				<Link to='/signup'>Signup</Link>
			</div>
		}
	</div>
);

function mapStateToProps(state){
	return{
		isAuthenticated:!!state.user.token
	}
}

export default connect(mapStateToProps,{logout})(homepage);