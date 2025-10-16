import { login, logout } from '../../feature/auth/authSlice.js';
import { validateFormCheck } from '../../utils/validate.js';


export const getLogin = (formData, param) => async(dispatch) => {

    if(validateFormCheck(param)) {        
        if("test" === formData.id && "1234" === formData.pwd) {               
            dispatch(login({"userId":formData.id}));   
            return true;          
        } 
    }
    return false;
}

export const getLogout = () => async(dispatch) => {
    dispatch(logout());
    return true;
}
