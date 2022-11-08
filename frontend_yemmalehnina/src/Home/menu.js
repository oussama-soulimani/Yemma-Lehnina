import React, { useEffect, useState }  from 'react';
import "./menu.css"
import { url } from './App';
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

function SubMenu(props){
  const color = ["#78451C","#355718","#4362AB","#4E9B00","#976CC8","#C94545"]
  const [products, setProducts]=useState(0)
  useEffect (()=>{
    fetch(url+"/"+props.category.toLowerCase(), {method:"GET"})
    // fetch(url+"/all", {method:"GET"})
    .then((res)=>(res.json())).then(data=>{setProducts(data)})
  },[]);

  var productsLines = []
  for(var i=0; i<products.length; i++){
    productsLines.push(
    <div className='productLineContainer'>
      <div className = 'productName'>{products[i]["name"]}</div>
      <div className = 'productName'>{products[i]["price"]} dh</div>
    </div>)
  }
  
  return(
    <div className='subMenu' style={{color:color[props.catNum]}}>
      <div className='blurredBackground'></div>
      <div className='overlay'>
        <div className='subHeader' >{props.category}</div>
        <div className={'productsLinesContainer'+String(props.catNum)}>
              {typeof(products)!="number"?productsLines:null}</div>
        <div className='backButtonContainer' onClick={()=>props.setClicked(null)}>
          <div className="backButton" style={{border:"3px solid "+color[props.catNum]}} >Back</div>
        </div>
      </div>
    </div>
    
  )
}

export default function Menu(props){
  const [clicked, setClicked] = useState(null)
  const categories = ["Coffees", "Thees", "Colds","Juices", "Breakfast", "Snacks"]
  
  const MenuElements = [];
  for (var i=0; i<categories.length; i++){
    MenuElements.push(<MenuElement type={categories[i]} key = {i} setClicked = {setClicked} num = {String(i)}  bigScreen = {props.bigScreen}/>)
  }
  return (
      <div className={props.bigScreen ?'BigMenu':'SmallMenu'} 
      style={moveStyleLeft(props.width, props.Ycoord, 0.15*props.height, 1, props.width)}>
        {clicked==null?MenuElements:<SubMenu catNum={clicked} category={categories[clicked]} setClicked={setClicked} />}
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
        onClick ={()=>props.setClicked(props.num)}
        >
        <img src={require("./"+category+".png")} className="Image" style={hover? {filter: "blur(4px)"}:null}/>
        {hover?<div className='subMenuName' style={{color: color[props.num]}}>{props.type}</div>:null}
        </div>
    )
}


  