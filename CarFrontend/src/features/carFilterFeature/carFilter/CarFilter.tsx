import style from "./CarFilter.module.css";
import Button from "@mui/material/Button";
import ExpandLess from "@mui/icons-material/ExpandLess";
import ExpandMore from "@mui/icons-material/ExpandMore";
import React, { useState } from "react";
import Collapse from "@mui/material/Collapse";
import { CarFilterDetails } from "../carFilterDetails/CarFilterDetails";


import {CarDTO} from "../DTO/CarDTO";

interface Props {
  carFilter: CarDTO;
}

export function CarFilter({ carFilter }: Props) {
  const [open, setOpen] = useState(false);

  return (
    <div className={style.Div}>
      <div className={style.DivCarFilterButton}>
        <Button fullWidth onClick={() => setOpen(!open)} variant="text">
          {" "}
          {carFilter.carName}
          {open ? <ExpandLess /> : <ExpandMore />}
        </Button>
      </div>
      <Collapse className={style.CarFilterCollapse} in={open}>
        <CarFilterDetails carTypeId={carFilter.carId}></CarFilterDetails>
      </Collapse>
    </div>
  );
}
