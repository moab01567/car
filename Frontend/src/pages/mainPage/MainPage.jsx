import * as React from 'react';
import MainPageStyle from "./MainPage.module.css";
import {CarBox} from "./carBox/CarBox";
import {createContext, useContext, useEffect, useState} from "react";
import {RequestCarsRegTransformer} from "../../Service/requestCarsReg/RequestCarsRegTransformer";
import {CarFinder} from "./carFinder/CarFinder";
import {LoadingIndicator} from "../../components/LoadingIndicator.jsx";

export function MainPage() {
    const [selectedFilterOptions, setSelectedFilterOptions] = useState({})
    const [arrayCarsIdAndReg, setArrayCarsIdAndReg] = useState([])
    const [loading,setLoading] = useState(false)



    async function handleFilterOptionRequest(e) {
        e.preventDefault();
        console.log(selectedFilterOptions)
        setLoading(true)
        setArrayCarsIdAndReg([])
        const dataArrayCarsIdAndReg = await RequestCarsRegTransformer(selectedFilterOptions);
        console.log(dataArrayCarsIdAndReg)
        setLoading(false)
        setArrayCarsIdAndReg(dataArrayCarsIdAndReg)
    }

  return (
        <div className={MainPageStyle.page}>
            <h1>Car Finder</h1>
            <CarFilterFeature></CarFilterFeature>
            <form className={MainPageStyle.from} onSubmit={handleFilterOptionRequest} >
                <div className={MainPageStyle.fromDiv}>
                    <CarFinder setSelectedFilterOptions={setSelectedFilterOptions }></CarFinder>
                </div>
            </form>
            {loading ? <LoadingIndicator></LoadingIndicator> : ""}
            {arrayCarsIdAndReg.length ? <h3>cars: {arrayCarsIdAndReg.length}</h3> : <h3></h3>}
                {arrayCarsIdAndReg.map((carIdAndReg, index) =>(
                    <CarBox key={carIdAndReg.carId} carIdAndReg={carIdAndReg} index={index} ></CarBox>
                ))}

        </div>
    );
}
