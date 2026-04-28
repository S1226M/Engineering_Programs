import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    students:[
        {id:1, name:"John Doe", age:20},
        {id:2, name:"Smit Maru", age:22},
        {id:3, name:"ABC", age:22}
    ]
}

const studentSlice = createSlice({
    name: "student",
    initialState,
    reducers:{
        addStudent: (state , action) => {
            console.log("Adding reducer called with payload: ", action.payload);
            state.students.push(action.payload);
            return state;
        },
        removeStudent: (state , action) => {
            state.students = state.students.filter((stu) => stu.id !== action.payload);
            return state;
        },
    },
});

export const {addStudent, removeStudent} = studentSlice.actions;
export default studentSlice.reducer;