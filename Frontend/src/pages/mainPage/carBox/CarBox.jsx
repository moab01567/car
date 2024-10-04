import {boxClasses, Collapse,TextField,Button,FormControlLabel,Checkbox} from "@mui/material";
import React, {useEffect, useMemo, useRef, useState} from "react";
import CarBoxStyle from "./CarBox.module.css";
import {CarInfo} from "./carInfo/CarInfo";
import {OwnerInfo}  from "./ownersInfo/OwnerInfo"
import {Navigate, useNavigate} from "react-router-dom";
import {AddPersonFrom} from "./addPersonFrom/AddPersonFrom";
import {RequestCarTransformer} from "../../../Service/requestCar/RequestCarTransformer";
import {RequestOwnersTransformer} from "../../../Service/requestOwners/RequestOwnersTransformer";



export function CarBox({ index, carIdAndReg}){
    const [open, isOpen] = useState(false)
    const [carDetails, setCarDetails] = useState({});
    const [ownersInfo, setOwnersInfo] = useState([]);

    async function getCarDetails(){
        const carDetailsData = await RequestCarTransformer(carIdAndReg.carId);
        console.log(carDetailsData);
        setCarDetails(carDetailsData);

        const ownersInfoData = await RequestOwnersTransformer(carIdAndReg.carId);
        console.log(ownersInfoData);
        setOwnersInfo(ownersInfoData);
    }


    return (<div className={CarBoxStyle.mainDiv} style={{borderColor:" #FFD700"}} >
        <h2 className={CarBoxStyle.mainDivH2} onClick={(e)=> {isOpen(!open); getCarDetails()}} >{carIdAndReg.regNumber}</h2>
        <Collapse in={open} timeout ="auto" unmountOnExit>
            <CarInfo carDetails={carDetails} setCarDetails={setCarDetails}></CarInfo>
            <OwnerInfo carDetails={carDetails} ownersInfo={ownersInfo} setOwnersInfo={setOwnersInfo} ></OwnerInfo>
            <AddPersonFrom carId={carIdAndReg.carId} setOwnersInfo={setOwnersInfo}></AddPersonFrom>
        </Collapse>
    </div>);

}