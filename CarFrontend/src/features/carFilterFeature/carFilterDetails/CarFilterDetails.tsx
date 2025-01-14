import React from "react";
import { CarFilterSelector } from "./CarFilterSelector";
import style from "./CarFilterDetails.module.css";
import { CarFilterDate } from "./CarFilterDate";
import { DateFilterCode, SelectFilterCode } from "../Enum";

interface Props {
  carTypeId: number;
}

export function CarFilterDetails({ carTypeId }: Props) {
  return (
    <div className={style.DivCarFilterDetails}>
      <CarFilterSelector
        carTypeId={carTypeId}
        selectFilterCode={SelectFilterCode.CAR_FUEL}
      ></CarFilterSelector>
      <CarFilterSelector
        carTypeId={carTypeId}
        selectFilterCode={SelectFilterCode.CAR_SEATS}
      ></CarFilterSelector>
      <CarFilterSelector
        carTypeId={carTypeId}
        selectFilterCode={SelectFilterCode.CAR_TRANSMISSION}
      ></CarFilterSelector>
      <CarFilterSelector
        carTypeId={carTypeId}
        selectFilterCode={SelectFilterCode.CAR_STATUS}
      ></CarFilterSelector>
      <CarFilterSelector
        carTypeId={carTypeId}
        selectFilterCode={SelectFilterCode.HANDLE_STATUS}
      ></CarFilterSelector>
      <CarFilterDate
        dateFilterCode={DateFilterCode.EU_FROM}
        carTypeId={carTypeId}
        name={"EU-From"}
      ></CarFilterDate>
      <CarFilterDate
        dateFilterCode={DateFilterCode.EU_TO}
        carTypeId={carTypeId}
        name={"EU-To"}
      ></CarFilterDate>
      <CarFilterDate
        dateFilterCode={DateFilterCode.REG_FROM}
        carTypeId={carTypeId}
        name={"Reg-From"}
      ></CarFilterDate>
      <CarFilterDate
        dateFilterCode={DateFilterCode.REG_TO}
        carTypeId={carTypeId}
        name={"Reg-To"}
      ></CarFilterDate>
    </div>
  );
}
