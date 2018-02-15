import {Link} from 'react-router-dom';
import axios from 'axios';

const homepage = ()=>(
	<div>
		<h1>Home Page</h1>
		<Link to='/login'>Login</Link>
	</div>
);

export default homepage;