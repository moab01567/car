import OwnerInfoStyle from "./OwnerInfo.module.css";
import {LoadingButton} from "@mui/lab"
import React, {useState} from "react";
import {RequestOwnersTransformer} from "../../../../Service/requestOwners/RequestOwnersTransformer";
import {RequestRemoveOwnerTransformer} from "../../../../Service/requestRemoveOwner/RequestRemoveOwnerTransformer";


export function OwnerInfo({ carDetails, ownersInfo, setOwnersInfo }) {
    const [loading, setLoading] = useState(false);


    async function handleRemoveClick(index, tlf){
        setLoading(true)
        const response = await RequestRemoveOwnerTransformer(ownersInfo[index].carID,tlf);
        setLoading(false)

        console.log(ownersInfo[index].carID)
        const ownersInfoData = await RequestOwnersTransformer(ownersInfo[index].carID);
        console.log(ownersInfoData);
        setOwnersInfo(ownersInfoData);

    }
    return <div className={OwnerInfoStyle.mainOwnerBox}>
        <h2>Owners:</h2>
        <div className={OwnerInfoStyle.ownerBox}>
            {ownersInfo.length === 0 ? (<p>No Owner found</p>) : (<p></p>)}

            {ownersInfo.map((owner, index) => (
                <div className={OwnerInfoStyle.allOwnersBox}  key={owner.tlf}>
                    <div className={OwnerInfoStyle.allOwners}>
                        <button className={OwnerInfoStyle.button}
                            onClick={() => navigator.clipboard.writeText(`${carDetails.reg}, ${owner.name}, ${carDetails.carType}`)}>copy
                            name info
                        </button>
                        <button className={OwnerInfoStyle.button} onClick={() => navigator.clipboard.writeText(`${owner.tlf}`)}>copy tlf</button>
                        <button className={OwnerInfoStyle.button} onClick={() => navigator.clipboard.writeText(`${JSON.stringify(carDetails)} ${JSON.stringify(owner)}`)}>copy note</button>
                        <p><strong>Telefonnummer:</strong> {owner.tlf}</p>
                        <p><strong>Navn:</strong> {owner.name}</p>
                        <p><strong>Sted:</strong> {owner.place}</p>
                        <p><strong>Kontaktet:</strong> {owner.contacted ? "Ja" : "Nei"}</p>
                        <LoadingButton
                            size="small"
                            onClick={(e) => handleRemoveClick(index, owner.tlf)}
                            loading={loading}
                            variant="outlined"
                            color="error">
                            Remove
                        </LoadingButton>
                    </div>
                </div>))}
        </div>
    </div>
}