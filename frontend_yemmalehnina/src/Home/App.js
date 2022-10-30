import React  from 'react';
import './App.css';
import "./fonts.css"
import logo from "./logo.svg"
import useMediaQuery from '@mui/material/useMediaQuery';
import Options from "./menu.png"
import {useState, useEffect, useCallback} from "react"
import dropdownIcon from "./DropdownIcon_or.svg"
import dropdownIconBright from "./DropdownIcon_bright.svg"
import bgVideo from "./coffee.mp4"
import Menu from './menu';
// dit is een test
function getWindowDimension(){
  const {innerWidth: width, innerHeight: height} = window;
  return {
    width,
    height 
  };
}

function useWindowDimensions() {
  const [windowDimensions, setWindowDimensions] = useState(getWindowDimension());

  useEffect(() => {
    function handleResize() {
      setWindowDimensions(getWindowDimension());
    }

    window.addEventListener('resize', handleResize);
    return () => window.removeEventListener('resize', handleResize);
  }, []);

  return windowDimensions;
}

function HeaderButton (props){
  const [hover, setHover] = useState(false);
  
  return (
    <div className= {!hover? 'HeaderButton ':'HeaderButtonHover'}
        onMouseEnter={()=>setHover(true)}
        onMouseLeave={()=>setHover(false)}
        >{props.buttonText}
        {props.buttonText=="Language" ? 
        <div className='DropdownButton'>
          {!hover ? <img src= {dropdownIcon} className='Dropdown'/>: 
          <img src= {dropdownIconBright} className='Dropdown'/>}
        </div>:null}
    </div>
  )
}

function Header(){
  const bigScreen = useMediaQuery('(min-width:600px)');
  return (
    <div className = "Header">
        <img src = {logo} className="Logo"/>
        {bigScreen ?
        <div className= "BottonsBoxLarge">
          <HeaderButton buttonText="Menu"/>
          <HeaderButton buttonText="Info"/>
          <HeaderButton buttonText="News"/>
          <HeaderButton buttonText="Language"/>
        </div>:
        <div className='OptionsBox'>
          <img src={Options} className="Options"></img>
        </div>
        }
    </div>
  )
}
function Video(){
  return (
    <div className='VideoBox'>
    <video className = "bgVideo" autoPlay loop muted src = {bgVideo}></video>      
    </div>
  )
}


function App() {
  const bigScreen = useMediaQuery('(min-width:1224px)');
  const [y, setY] = useState(window.scrollY);
  const {height, width} = useWindowDimensions();

  
  const handleNavigation = useCallback(
    e => {
      const window = e.currentTarget;
      setY(window.scrollY);
    }, [y]
  );
  
  useEffect(() => {
    setY(window.scrollY);
    window.addEventListener("scroll", handleNavigation);
  
    return () => {
      window.removeEventListener("scroll", handleNavigation);
    };
  }, [handleNavigation]);


  const moveStyleLeft = (Ycoord)=>({
    display: "flex", 
    flexDirection:"column", 
    alignItems: "center", 
    zIndex: 8, 
    position: "fixed",
    transform: "translateX(-"+String(Ycoord)+"px)",
    opacity: bigScreen? 1-y/(0.3*width):1-y/(0.5*width) ,
  })

  const [response, setResponse] = useState(null)
  const handleClick = ()=>{
    fetch("http://localhost:8080/api/product", {method:"GET"})
    .then((res)=>(res.json())).then(response=>console.log(response[0]))
  }
  
  return (
    <div className="App">
      <Header/>
      <Video/>
      <div className={bigScreen? 'Info content':"InfoSmall content"} 
      style={moveStyleLeft(y)}>
        <div className={bigScreen? 'Subheader bigSubHeader': "Subheader smallSubHeader"}>Yemma Lehnina </div>  
        <div className='subBoxText'>
          Lorem ipsum dolor sit amet. 33 quae maxime hic eaque
          optio est dolor consequuntur eos perferendis saepe </div>  
        <div className= 'AboutUs' onClick={handleClick}> Over ons </div>  
      </div>
      <Menu bigScreen={bigScreen} height = {height} width = {width} Ycoord={y}/>
    <div className='scroll'></div>
    </div>
  );
}

export default App;
