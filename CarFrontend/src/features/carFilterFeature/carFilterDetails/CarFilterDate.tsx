import React, { useEffect, useState } from "react";
import { DatePicker, LocalizationProvider } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import style from "./CarFilterDetails.module.css";
import { DateFilterCode } from "../Enum";
import {LocalStorageCarFilter} from "../LocalStorageCarFilter";
import dayjs, { Dayjs } from "dayjs";
import "dayjs/locale/de";

interface Props {
  name: string;
  carTypeId: number;
  dateFilterCode: DateFilterCode;
}

export function CarFilterDate({ name, carTypeId, dateFilterCode }: Props) {
  const [date, setDate] = useState<Dayjs | null>(null);

  function getDateFromLocalStorageIfAvailable() {
    const selectedDate: string = LocalStorageCarFilter.getSelectedDate(carTypeId, dateFilterCode);
    setDate(selectedDate.length === 0 ? null : dayjs(selectedDate));
  }

  function handleOnChange(date: Dayjs | null) {
    if (!date) {
      LocalStorageCarFilter.updateSelectedDate(carTypeId, dateFilterCode, "");
    } else {
      LocalStorageCarFilter.updateSelectedDate(carTypeId, dateFilterCode, date.format("YYYY-MM-DD"));
      console.log(date.format("YYYY-MM-DD"));
    }

    setDate(date);
  }

  useEffect(() => {
    getDateFromLocalStorageIfAvailable();
  }, []);

  return (
    <div className={style.DivCarFilterDate}>
      <LocalizationProvider adapterLocale={"de"} dateAdapter={AdapterDayjs}>
        <DatePicker
          label={name}
          value={date}
          onChange={(newValue) => handleOnChange(newValue)}
        />
      </LocalizationProvider>
    </div>
  );
}
