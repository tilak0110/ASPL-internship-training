import { useDispatch, useSelector } from "react-redux";
import { counterActions, privateActions } from "../store";
import { useRef } from "react";

const Controls = ()=>{
    const dispatch = useDispatch();
    const inputValue= useRef();
    const privateDiv = useSelector((store)=> store.privacy.value)
    const handleAdd =()=>{
        dispatch(counterActions.add({num: inputValue.current.value}));     
        inputValue.current.value="";   
    }
    const handleSubstract =()=>{
        dispatch(counterActions.substract({num: inputValue.current.value}));   
        inputValue.current.value="";     
    }
    return <>

            <div className="d-grid gap-2 d-sm-flex justify-content-sm-center">
                <button type="button" className="btn btn-primary" onClick={()=>dispatch(counterActions.increment())}>+1</button>
                <button type="button" className="btn btn-success" onClick={()=>dispatch(counterActions.decrement())}>-1</button>
                <button type="button" className="btn btn-primary" onClick={()=>dispatch(privateActions.toggle())}>toggle</button>
                <button type="button" className="btn btn-primary" onClick={()=>dispatch(counterActions.reset())}>reset</button>
            </div>
            <div className="d-grid gap-2 d-sm-flex justify-content-sm-center">
                <input type="text" ref={inputValue} placeholder="Enter Number" style={{width: "100px"}}
                disabled = {privateDiv} />
                <button type="button" className="btn btn-primary" onClick={handleAdd}>Add</button>
                <button type="button" className="btn btn-success" onClick={handleSubstract}>Substract</button>
            </div>
     </>
}
export default Controls;