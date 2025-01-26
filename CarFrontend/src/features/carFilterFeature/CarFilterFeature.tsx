import React, { useEffect, useState } from "react";
import { CarFilter } from "./carFilter/CarFilter";
import CarFilterStyle from "./CarFilterFeature.module.css";
import Button from "@mui/material/Button";
import "./LocalStorageCarFilter";
import { LocalStorageCarFilter} from "./LocalStorageCarFilter";

import {CarDTO} from "./service/APIGetAvailableCars/CarDTO";
import {
    APIPostCarFilterAndOptionsDTO,
    CarFilterAndOptionMapper
} from "./service/APIPostCarFilterAndOptions/SelectedFilterOptionDTOAndMapper";
import {FilterSortBy} from "./FilterSortBy/FilterSortBy";
import {SortFilterCode} from "./Enum";
import {APIPostCarFilterAndOptions} from "./service/APIPostCarFilterAndOptions/APIPostCarFilterAndOptions";
import {APIGetAvailableCars} from "./service/APIGetAvailableCars/APIGetAvailableCars";



export function CarFilterFeature() {
  const [carFilters, setCars] = useState<CarDTO[] | null>(null);
  const [selectedSortFilterCode, setSelectedSortFilterCode] = useState<SortFilterCode | null>(null)

  useEffect(() => {
    getCarsToFilter();
  }, []);

function handleFilterClick() {
     const APIPostCarFilterAndOptionsDTO:APIPostCarFilterAndOptionsDTO=CarFilterAndOptionMapper(selectedSortFilterCode,LocalStorageCarFilter.getFilterDate())
    APIPostCarFilterAndOptions(APIPostCarFilterAndOptionsDTO)
}

  async function getCarsToFilter() {
    const cars: CarDTO[] = await APIGetAvailableCars();
    setCars(cars);
    cars.forEach((car) => LocalStorageCarFilter.addCarToFilterData(car.carId));
  }

  function handleSortBy(sortFilterCode:SortFilterCode | null){
    setSelectedSortFilterCode(sortFilterCode)
      console.log(sortFilterCode)
    }

  if (carFilters === null) {
    return (
      <div className={CarFilterStyle.Div}>
        <h2>Car Filter</h2>
        loading...
      </div>
    );
  }

  return (
    <div className={CarFilterStyle.Div}>
      <h2>Car Filter</h2>
      <div className={CarFilterStyle.CarFilterDiv}>
        {carFilters.map((carFilter) => (
          <CarFilter key={carFilter.carId} carFilter={carFilter}></CarFilter>
        ))}
      </div>
       <FilterSortBy setSelectedFilter={handleSortBy}></FilterSortBy>
      <Button onClick={handleFilterClick} variant="contained">Filter</Button>
    </div>
  );
}
