import "bootstrap/dist/css/bootstrap.min.css"
import './App.css'
import Header from './components/Header'
import DisplayCounter from './components/DisplayCounter'
import Container from './components/Container'
import Controls from './components/Controls'
import PrivateArea from './components/PrivateArea'
import { useSelector } from "react-redux"

function App() {
  const privateDiv = useSelector((store)=> store.privacy.value)

  return (
    <>
      <center className="px-4 py-5 my-5 text-center" style={{margin: "20%"}}>
        
        <Container>
          <div className="col-lg-6 mx-auto">
            <Header/>
            {!privateDiv?<DisplayCounter/>:<PrivateArea/>}
            
            <Controls/>
            
          </div>
        </Container>   
      </center>
    </>
  )
}

export default App
