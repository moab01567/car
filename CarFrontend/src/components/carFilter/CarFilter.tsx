import styleCarFilter from "./CarFilter.module.css";
import Select from "react-select";
import {
  GET_CAR_OPTION_URL_STRUCTURE,
  ResCarFilter,
} from "../../service/ApiInterface.ts";
import { useEffect, useState } from "react";
import { APIGetAllCarFilters } from "../../service/carFilter/APICarFilters.ts";
import { LoadingIndicator } from "../loading/LoadingIndicator.tsx";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs/AdapterDayjs";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";

interface Props {
  carType: ResCarFilter;
}
interface CarOptionStructure {
  carFuel: ResCarFilter[];
  carSeats: ResCarFilter[];
  carStatus: ResCarFilter[];
  handleStatus: ResCarFilter[];
  transmission: ResCarFilter[];
}

export function CarFilter({ carType }: Props) {
  const [carOptions, setCarOptions] = useState<CarOptionStructure | null>(null);

  async function getFilterOptions() {
    let [carFuel, carSeats, carStatus, handleStatus, transmission] =
      await Promise.all([
        APIGetAllCarFilters(GET_CAR_OPTION_URL_STRUCTURE.carFuel.url),
        APIGetAllCarFilters(GET_CAR_OPTION_URL_STRUCTURE.carSeats.url),
        APIGetAllCarFilters(GET_CAR_OPTION_URL_STRUCTURE.carStatus.url),
        APIGetAllCarFilters(GET_CAR_OPTION_URL_STRUCTURE.handleStatus.url),
        APIGetAllCarFilters(GET_CAR_OPTION_URL_STRUCTURE.transmission.url),
      ]);
    setCarOptions({
      carFuel: carFuel,
      carSeats: carSeats,
      carStatus: carStatus,
      handleStatus: handleStatus,
      transmission: transmission,
    });
  }

  useEffect(() => {
    getFilterOptions();
  }, []);

  return (
    <div className={styleCarFilter.div}>
      {carOptions === null ? (
        <LoadingIndicator></LoadingIndicator>
      ) : (
        <div className={styleCarFilter.selectDiv}>
          <h2>{carType.optionName}</h2>
          <Select
            className={styleCarFilter.selector}
            options={carOptions.carSeats}
            getOptionLabel={(carSeat) => carSeat.optionName}
            getOptionValue={(carSeat) => carSeat.optionId + ""}
            placeholder={"car Seats"}
            closeMenuOnSelect={false}
            isMulti={true}
          ></Select>
          <Select
            className={styleCarFilter.selector}
            placeholder={"Fuel"}
            closeMenuOnSelect={false}
            options={carOptions.carFuel}
            getOptionLabel={(carFuel) => carFuel.optionName}
            getOptionValue={(carFuel) => carFuel.optionId + ""}
            isMulti
          />
          <Select
            className={styleCarFilter.selector}
            placeholder={"Sar Status"}
            closeMenuOnSelect={false}
            options={carOptions.carStatus}
            getOptionLabel={(carStatus) => carStatus.optionName}
            getOptionValue={(carStatus) => carStatus.optionId + ""}
            isMulti
          />
          <Select
            className={styleCarFilter.selector}
            placeholder={"Handle Status"}
            closeMenuOnSelect={false}
            options={carOptions.handleStatus}
            getOptionLabel={(handleStatus) => handleStatus.optionName}
            getOptionValue={(handleStatus) => handleStatus.optionId + ""}
            isMulti
          />
          <Select
            className={styleCarFilter.selector}
            placeholder={"Transmission"}
            closeMenuOnSelect={false}
            options={carOptions.transmission}
            getOptionLabel={(transmission) => transmission.optionName}
            getOptionValue={(transmission) => transmission.optionId + ""}
            isMulti
          />
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <span className={styleCarFilter.selector}>
              <DatePicker label="carFrom" />
            </span>
          </LocalizationProvider>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <span className={styleCarFilter.selector}>
              <DatePicker className={styleCarFilter.selector} label="carTo" />
            </span>
          </LocalizationProvider>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <span className={styleCarFilter.selector}>
              <DatePicker className={styleCarFilter.selector} label="euFrom" />
            </span>
          </LocalizationProvider>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <span className={styleCarFilter.selector}>
              <DatePicker className={styleCarFilter.selector} label="euTo" />
            </span>
          </LocalizationProvider>
        </div>
      )}
    </div>
  );
}
