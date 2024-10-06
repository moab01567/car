import CarBoxStyle from "./CarInfo.module.css";
import React, { useEffect, useState } from "react";
import { RequestCarTransformer } from "../../../../Service/requestCar/RequestCarTransformer";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import {DatePicker, LocalizationProvider} from "@mui/x-date-pickers";
import {FormControl, InputLabel, Select, MenuItem} from '@mui/material/';
import 'dayjs/locale/de';
import {FilterDataApi} from "../../../../Service/requestFilterData/FilterDataApi";
import {UpdateHandleStatusApi} from "../../../../Service/requestUpdateHandleStatus/UpdateHandleStatusApi";
import dayjs from 'dayjs';
import {UpdateFollowUpApi} from "../../../../Service/requestUpdateHandleStatus/UpdateFollowUpApi";

export function CarInfo({ carDetails, setCarDetails }) {
    const [handStatusOptions,setHandStatusOptions] = useState([])

    async function handleOnChangeHandStatusOptions(handleStatusId){
       const response = await UpdateHandleStatusApi("handStatus",carDetails.carID, handleStatusId)
        const carDetailsData = await RequestCarTransformer(carDetails.carID);
        console.log(carDetailsData);
        setCarDetails(carDetailsData);
    }

    async function handleOnChangeFollowUpDate(followUpDate){
        console.log(followUpDate)
        if (followUpDate !== null){
            followUpDate = `${followUpDate["$y"]}-${followUpDate["$M"] + 1}-${followUpDate["$D"]}`
        }
        const response = await UpdateFollowUpApi(carDetails.carID, followUpDate)
        const carDetailsData = await RequestCarTransformer(carDetails.carID);
        console.log(carDetailsData);
        setCarDetails(carDetailsData);
    }


    useEffect(()=>{
         async function getHandleStatusOptions(){
             setHandStatusOptions(await FilterDataApi("handleStatus"))
         }
        getHandleStatusOptions()
},[])


    return (
        <div className={CarBoxStyle.carInfo}>
            <p className={CarBoxStyle.carInfoP}>Car ID: {carDetails.carID}</p>
            <p className={CarBoxStyle.carInfoP}>Registreringsnummer: {carDetails.reg}</p>
            <p className={CarBoxStyle.carInfoP}>VIN: {carDetails.vin}</p>
            <p className={CarBoxStyle.carInfoP}>Farge: {carDetails.color}</p>
            <p className={CarBoxStyle.carInfoP}>Antall dører: {carDetails.totalDoors}</p>
            <p className={CarBoxStyle.carInfoP}>Antall seter: {carDetails.totalSeats}</p>
            <p className={CarBoxStyle.carInfoP}>Antall aksler i bruk: {carDetails.axlesInUse}</p>
            <p className={CarBoxStyle.carInfoP}>Antall motorer: {carDetails.totalEngines}</p>
            <p className={CarBoxStyle.carInfoP}>Lengde: {carDetails.length} meter</p>
            <p className={CarBoxStyle.carInfoP}>Bredde: {carDetails.width} meter</p>
            <p className={CarBoxStyle.carInfoP}>Registrert første gang: {carDetails.registeredFirst}</p>
            <p className={CarBoxStyle.carInfoP}>Registrert første gang i Norge: {carDetails.registeredFirstNorway}</p>
            <p className={CarBoxStyle.carInfoP}>Neste EU-kontroll: {carDetails.nextEUControl}</p>
            <p className={CarBoxStyle.carInfoP}>Merknad: {carDetails.note || 'Ingen merknader'}</p>
            <p className={CarBoxStyle.carInfoP}>Girkasse: {carDetails.transmission || 'Ikke Notert'}</p>
            <p className={CarBoxStyle.carInfoP}>Status: {carDetails.status}</p>
            <p className={CarBoxStyle.carInfoP}>Biltype: {carDetails.carType}</p>
            <p className={CarBoxStyle.carInfoP}>Drivstoff: {carDetails.fuel}</p>

            {carDetails.handleStatusId ? (<><FormControl sx={{width: 200}}>
                <InputLabel id="demo-simple-select-label">Handle Status</InputLabel>
                <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    value={carDetails.handleStatusId}
                    label="handle Status"
                    onChange={(event) => handleOnChangeHandStatusOptions(event.target.value)}>
                    {handStatusOptions.map((option) => (
                            <MenuItem key={option.optionId} value={option.optionId}>{option.optionName}</MenuItem>
                        )
                    )}
                </Select>

            </FormControl>
                <LocalizationProvider dateAdapter={AdapterDayjs} adapterLocale="de">
                    <DatePicker value={carDetails.followUp ? dayjs(carDetails.followUp) : carDetails.followUp}
                                label={"FollowUp Date"}
                                onChange={handleOnChangeFollowUpDate}
                    />
                </LocalizationProvider>
            </>) : (<p>Loading...</p>)}


            <a href={"https://regnr.1881.no/" + carDetails.reg} target="_blank" rel="noopener noreferrer">
                <button className={CarBoxStyle.carInfoButton}>Bil 1881</button>
            </a>
            <a href={"https://www.vegvesen.no/dinside/kjoretoy/finn-eier-og-kjoretoyopplysninger#/finn-eier-og-kjoretoyopplysninger?kjennemerke=" + carDetails.reg} target="_blank" rel="noopener noreferrer">
                <button className={CarBoxStyle.carInfoButton}>Bil Vegvesen</button>
            </a>
            <button className={CarBoxStyle.carInfoButton} onClick={() => navigator.clipboard.writeText(JSON.stringify(carDetails).replaceAll(",", "\n"))}>Copy
                car Info
            </button>
        </div>
    );
}
