import * as React from 'react';
import MainPageStyle from "./MainPage.module.css";
import { useNavigate } from "react-router-dom";
import Button from '@mui/material/Button';
import {FilterSelector} from "./carFinder/FilterSelector";
import {CarBox} from "./carBox/CarBox";
import {createContext, useContext, useEffect, useState} from "react";
import {CarOptions} from "../../components/api/CarOptions";
import {DatePicker, LocalizationProvider} from "@mui/x-date-pickers";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import dayjs from "dayjs";
import {FilterOptionRequest} from "../../components/api/FilterOptionRequest";
import {FilterDataTransformer} from "../../Service/requestFilterData/FilterDataTransformer";
import {RequestCarsRegTransformer} from "../../Service/requestCarsReg/RequestCarsRegTransformer";
import {CarFinder} from "./carFinder/CarFinder";


export function MainPage() {
    const [selectedFilterOptions, setSelectedFilterOptions] = useState({})
    const [selectedFilters, setSelectedFilters] = useState({})
    const [arrayCarsIdAndReg, setArrayCarsIdAndReg] = useState([])


    async function handleFilterOptionRequest(e) {
        e.preventDefault();
        console.log(selectedFilterOptions)
        const dataArrayCarsIdAndReg = await RequestCarsRegTransformer(selectedFilterOptions);
        console.log(dataArrayCarsIdAndReg)
        setArrayCarsIdAndReg(dataArrayCarsIdAndReg)
    }

  return (
        <div className={MainPageStyle.page}>
            <h1>Car Finder</h1>

            <form className={MainPageStyle.from} onSubmit={handleFilterOptionRequest} >
                <div className={MainPageStyle.fromDiv}>
                    <CarFinder setSelectedFilterOptions={setSelectedFilterOptions }></CarFinder>
                </div>
            </form>

                {arrayCarsIdAndReg.map((carIdAndReg, index) =>(
                    <CarBox key={carIdAndReg.carId} carIdAndReg={carIdAndReg} index={index} ></CarBox>
                ))}
        </div>
    );
}
