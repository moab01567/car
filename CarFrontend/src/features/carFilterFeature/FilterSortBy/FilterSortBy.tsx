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

interface Props{
    setSelectedFilter:(sortFilterCode:SortFilterCode | null) => void;
}

export function FilterSortBy({ setSelectedFilter }:Props) {
    const [selectedCheckBoxes, setSelectedCheckBoxes] = useState<CheckBoxSelected[]>(checkBoxSelected)

    function handleChange(code: SortFilterCode) {
        setSelectedCheckBoxes(selectedCheckBoxes.map(selectedCheckBox=> {
            if (selectedCheckBox.code === code) selectedCheckBox.selected =  !selectedCheckBox.selected
            else selectedCheckBox.selected = false

            if (selectedCheckBox.code === code && !selectedCheckBox.selected ) setSelectedFilter(null);
            if (selectedCheckBox.code === code && selectedCheckBox.selected ) setSelectedFilter(code);

            return selectedCheckBox
        }))
    }

    return <div className={style.SortingByDiv}>
        <h2>Sort by</h2>
        <div className={style.SortingByDiv2}>
            {selectedCheckBoxes.map(SelectedCheckBox=><FormControlLabel key={SelectedCheckBox.code} control={<Checkbox checked={SelectedCheckBox.selected}/>}
                                                                        label={SelectedCheckBox.label} onChange={event=> handleChange(SelectedCheckBox.code)}/>)}
        </div>
    </div>
}