/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



const httpRequest = axios.create({
  baseURL: 'http://localhost:8080/busapp/api/'
});

 const get = async (path, options = {}) => {
  const response = await httpRequest.get(path, options);
  return response.data;
};

 const post = async (path, data, options = {}) => {
  const response = await httpRequest.post(path, data, options);
  return response.data;
};


const getForm = (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);
    const inputObject = Object.fromEntries(formData);
    
    //console.log(inputObject);
    return inputObject;
};

const handleFromClick = async (e) => {
    const formData = getForm(e);
    console.log(formData);
//    try {
//    const res = await httpRequest.post("route", {params: {
//        q
//      }});
//    
//    handleMsg(res);
//    console.log(res);
//  } catch (error) {
//    console.log(error);
//  }
};
