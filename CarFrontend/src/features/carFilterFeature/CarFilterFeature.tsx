import React, { useEffect, useState } from "react";
import { CarFilter } from "./carFilter/CarFilter";
import {APIGetAvailableCars, APIPostCarFilterAndOptions} from "./service/CarFilterService";
import CarFilterStyle from "./CarFilterFeature.module.css";
import Button from "@mui/material/Button";
import "./LocalStorageCarFilter";
import {addCarToFilterData, getFilterDate} from "./LocalStorageCarFilter";

import {CarDTO} from "./DTO/CarDTO";
import {SelectedFilterOptionDTOMapper} from "./DTO/SelectedFilterOptionDTOAndMapper";

function handleFilterClick() {

    APIPostCarFilterAndOptions(SelectedFilterOptionDTOMapper(getFilterDate()))
}

export function CarFilterFeature() {
  const [carFilters, setCars] = useState<CarDTO[] | null>(null);

  useEffect(() => {
    getCarsToFilter();
  }, []);

  async function getCarsToFilter() {
    const cars: CarDTO[] = await APIGetAvailableCars();
    setCars(cars);
    cars.forEach((car) => addCarToFilterData(car.carId));
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
      <Button onClick={handleFilterClick} variant="contained">Filter</Button>
    </div>
  );
}
