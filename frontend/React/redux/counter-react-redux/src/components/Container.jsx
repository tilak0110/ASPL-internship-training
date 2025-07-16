const Container = ({children}) =>{
    return (<center className="card" style={{width: "50%"}}>
  
                <div className="card-body">
                    {children}
                </div>
            </center>) ;

}
export default Container;