import React, { useState }  from 'react';
import stylo from "./menu.css";
import Coffee from "./Coffees.png";
import Thees from "./Thees.png"
import Colds from "./Colds.png"
import Juices from "./Juices.png"
import Snacks from "./Snacks.png"
import Breakfast from "./Breakfast.png"
import { height } from '@mui/system';


const moveStyleLeft = (width, Ycoord, top, screenNum, peakBrightness)=>(
    
    Ycoord<screenNum*peakBrightness? {
    position: "fixed",
    width:"100%",
    left: width,
    top: top,
    transform: "translateX(-"+String(Ycoord)+"px)",
    opacity:Ycoord/peakBrightness,
  }:
  {position: "fixed",
  width:"100%",
  left: width,
  top: top,
  transform: "translateX(-"+String(Ycoord)+"px)",
  opacity:-Ycoord/peakBrightness+2,}
)

export default function Menu(props){
      console.log(props.Ycoord, props.width, -(props.Ycoord-props.width)^2+1 )
    return (
      <div className={props.bigScreen ?'BigMenu':'SmallMenu'} 
      style={moveStyleLeft(props.width, props.Ycoord, 0.225*props.height, 1, props.width)}>
        <MenuElement type="Coffees" num = "0" />
        <MenuElement type="Thees" num="1"/>
        <MenuElement type="Colds" num="2"/>
        <MenuElement type="Juices" num="3"/>
        <MenuElement type="Breakfast" num="4"/>
        <MenuElement type="Snacks" num="5"/>
      </div>
    )
}

function MenuElement(props){
    const category = props.type;
    const [hover, setHover] = useState(false)
    const color = [
        "#78451C",
        "#355718",
        "#4362AB",
        "#4E9B00",
        "#976CC8",
        "#C94545",
        

    ]
    return (
        <div className='MenuElement' 
        onMouseEnter={()=> setHover(true)}
        onMouseLeave={()=> setHover(false)}
        >
        <img src={require("./"+category+".png")} className="Image" style={hover? {filter: "blur(4px)"}:null}/>
        {hover?<div className='subMenuName' style={{color: color[props.num]}}>{props.type}</div>:null}
        </div>
    )
}


  