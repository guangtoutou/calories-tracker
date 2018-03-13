import {Link} from 'react-router-dom';
import {connect} from 'react-redux';
import ConfirmEmailMessage from '../messages/confirmEmailMessage';


const DashBoard	= ({isConfirmed})=>(
    <div>
        {!isConfirmed && <ConfirmEmailMessage />}
    </div>
)

function mapStateToProps(state){
    return {
        isConfirmed: !!state.user.confirmed
    }
}
	
export default connect(mapStateToProps)(DashBoard);
