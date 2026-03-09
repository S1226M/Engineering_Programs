import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    students:[
        {id:1, name:"John Doe", age:20},
        {id:2, name:"Smit Maru", age:22}
    ]
}

const studentSlice = createSlice({
    name: "student",
    initialState,
    reducers:{
        addStudent: (state , action) => {
            state.push([{id:3,name:"Darshan", age:21}]);
            return state;
        },
        removeStudent: (state , action) => {
            return state;
        },
    },
});

export const {addStudent} = studentSlice.actions;
export default studentSlice.reducer;