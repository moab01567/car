import {Button, Checkbox, FormControlLabel, TextField} from "@mui/material";
import AddPersonFromStyle from "./AddPersonFrom.module.css";
import React, {useState} from "react";
import {ApiAddNewOwner} from "../../../../components/api/ApiAddNewOwner";
import {AddOwnerTransformer} from "../../../../Service/requestAddOwner/AddOwnerTransformer";
import {RequestOwnersTransformer} from "../../../../Service/requestOwners/RequestOwnersTransformer";


export function AddPersonFrom({carId,setOwnersInfo}) {
    const [tlf,setTlf] = useState("")
    const [name,setName] = useState("")
    const [place,setPlace] = useState("")
    const [contacted,setContacted] = useState(false)

    async function  handleClick (e) {

        const response = await AddOwnerTransformer(carId,tlf,name,place,contacted)
        if (response === null)return;
        const ownersInfoData = await RequestOwnersTransformer(carId);
        console.log(ownersInfoData);
        setOwnersInfo(ownersInfoData);
        setTlf("")
        setName("")
        setPlace("")
        setContacted(false)

    }

    return <div className={AddPersonFromStyle.mainBox}>
        <h3>Add Person</h3>
        <div>
            <TextField  required id="tlf" onChange={event =>setTlf(event.target.value) } value={tlf} label="TLF" variant="outlined"/>
            <TextField required id="name" onChange={event =>setName(event.target.value) } value={name} label="Name" variant="outlined"/>
            <TextField required id="place" onChange={event =>setPlace(event.target.value) } value={place} label="place" variant="outlined"/>
        </div>
            <FormControlLabel control={<Checkbox checked={contacted} onChange={event => setContacted(event.target.checked) } />} label="Contacted"/>
            <Button variant="outlined" onClick={handleClick} >Add Person</Button>
        </div>
}