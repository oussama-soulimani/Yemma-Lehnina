import React, { Component }  from 'react';
import './App.css';
import "./fonts.css"
import logo from "./logo.svg"
import useMediaQuery from '@mui/material/useMediaQuery';
import menu from "./menu.png"
import {useState, useEffect, useCallback} from "react"
import dropdownIcon from "./DropdownIcon_or.svg"
import dropdownIconBright from "./DropdownIcon_bright.svg"
import bgVideo from "./coffee.mp4"
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
  const matches = useMediaQuery('(min-width:600px)');
  return (
    <div className = "Header">
        <img src = {logo} className="Logo"/>
        {matches ?
        <div className= "BottonsBoxLarge">
          <HeaderButton buttonText="Menu"/>
          <HeaderButton buttonText="Info"/>
          <HeaderButton buttonText="News"/>
          <HeaderButton buttonText="Language"/>
        </div>:
        <div className='MenuBox'>
          <img src={menu} className="Menu"></img>
        </div>
        }
    </div>
  )
}
function Video(){
  const {height, width} = useWindowDimensions();
  return (
    <div className='VideoBox'>
    <video className = "bgVideo" muted
    src = {bgVideo}
    >
    </video>      
    </div>
  )
}
function App() {
  const matches = useMediaQuery('(min-width:1224px)');
  const [y, setY] = useState(window.scrollY);
  const [s, sets] = useState(false);
  const handleNavigation = useCallback(
    e => {
      const window = e.currentTarget;
      if (y > window.scrollY) {
        console.log("scrolling up");
      } else if (y < window.scrollY) {
        sets(!s);
      }
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
  return (
    <div className="App">
      <Header/>
      <Video/>
    <div className={matches? 'Info content':"InfoSmall content"} >
    <div className={matches? 'Subheader bigSubHeader': "Subheader smallSubHeader"}>Yemma Lehnina </div>  
    <div className='subBoxText'>
      Lorem ipsum dolor sit amet. 33 quae maxime hic eaque
  optio est dolor consequuntur eos perferendis saepe {String(s)}</div>  
    <div className='AboutUs'> Over ons </div>  
    </div>
    <div className='scroll'></div>
    </div>
  );
}

export default App;
