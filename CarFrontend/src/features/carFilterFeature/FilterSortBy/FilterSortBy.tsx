// @ts-ignore
import style from "./FitlerSortBy.module.css";
import {Checkbox, FormControlLabel} from "@mui/material";
import React, {useState} from "react";
import {SortFilterCode} from "../Enum";


interface CheckBoxSelected {
    label:string;
    selected:boolean
    code:SortFilterCode

}

const checkBoxSelected:CheckBoxSelected[] = [
    {label:"EU",selected:false, code:SortFilterCode.EU },
    {label:"Follow up",selected:false, code:SortFilterCode.FOLLOW_UP }
]

export function FilterSortBy() {
    const [selectedCheckBoxes, setSelectedCheckBoxes] = useState<CheckBoxSelected[]>(checkBoxSelected)

    function handleChange(code: SortFilterCode) {
        setSelectedCheckBoxes(selectedCheckBoxes.map(setSelectedCheckBox=> {
            if (setSelectedCheckBox.code === code)setSelectedCheckBox.selected =  !setSelectedCheckBox.selected
            else setSelectedCheckBox.selected = false
            return setSelectedCheckBox
        }))
    }

    return <div className={style.SortingByDiv}>
        <h2>Sort by</h2>
        <div className={style.SortingByDiv2}>
            {selectedCheckBoxes.map(setSelectedCheckBox=><FormControlLabel control={<Checkbox checked={setSelectedCheckBox.selected}/>}
                                                                           label={setSelectedCheckBox.label} onChange={event=> handleChange(setSelectedCheckBox.code)}/>)}
        </div>
    </div>
}