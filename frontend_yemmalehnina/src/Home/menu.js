import React, { useState }  from 'react';


const moveStyleLeft = (width, Ycoord, top, screenNum, peakBrightness)=>(
    
    Ycoord<screenNum*peakBrightness? {
    position: "fixed",
    left: width,
    top: top,
    transform: "translateX(-"+String(Ycoord)+"px)",
    opacity:Ycoord/peakBrightness,
  }:
  {position: "fixed",
  left: width,
  top: top,
  transform: "translateX(-"+String(Ycoord)+"px)",
  opacity:-Ycoord/peakBrightness+2,
}
)

export default function Menu(props){
    return (
      <div className={props.bigScreen ?'BigMenu':'SmallMenu'} 
      style={moveStyleLeft(props.width, props.Ycoord, 0.15*props.height, 1, props.width)}>
        <MenuElement type="Coffees" num = "0"  bigScreen = {props.bigScreen}/>
        <MenuElement type="Thees" num="1" bigScreen = {props.bigScreen}/>
        <MenuElement type="Colds" num="2" bigScreen = {props.bigScreen}/>
        <MenuElement type="Juices" num="3" bigScreen = {props.bigScreen}/>
        <MenuElement type="Breakfast" num="4" bigScreen = {props.bigScreen}/>
        <MenuElement type="Snacks" num="5" bigScreen = {props.bigScreen}/>
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
        <div className={props.bigScreen? 'MenuElement': "MenuElementPhone"} 
        onMouseEnter={()=> setHover(true)}
        onMouseLeave={()=> setHover(false)}
        >
        <img src={require("./"+category+".png")} className="Image" style={hover? {filter: "blur(4px)"}:null}/>
        {hover?<div className='subMenuName' style={{color: color[props.num]}}>{props.type}</div>:null}
        </div>
    )
}


  