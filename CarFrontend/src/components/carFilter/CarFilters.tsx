import { CarFilter } from "./CarFilter.tsx";
import styleCarFilters from "./CarFilters.module.css";
import { useEffect, useState } from "react";
import {
  GET_CAR_OPTION_URL_STRUCTURE,
  ResCarFilter,
} from "../../service/ApiInterface.ts";
import { APIGetAllCarFilters } from "../../service/carFilter/APICarFilters.ts";
import { LoadingIndicator } from "../loading/LoadingIndicator.tsx";
import { Button } from "@mui/material";

export function CarFilters() {
  const [carType, setCarType] = useState<ResCarFilter[] | null>(null);

  async function getCarTypes() {
    let [carType] = await Promise.all([
      APIGetAllCarFilters(GET_CAR_OPTION_URL_STRUCTURE.carType.url),
    ]);
    setCarType(carType);
  }

  useEffect(() => {
    getCarTypes();
  }, []);

  return (
    <div className={styleCarFilters.div}>
      <div className={styleCarFilters.carFilterDiv}>
        {carType === null ? (
          <LoadingIndicator></LoadingIndicator>
        ) : (
          carType.map((carType) => (
            <CarFilter key={carType.optionId} carType={carType}></CarFilter>
          ))
        )}
      </div>
      <Button variant={"outlined"}>filter</Button>
    </div>
  );
}
