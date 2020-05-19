let getBtn = document.querySelector('#get-btn');



const getData = () => {
    axios.get('http://localhost:8181/getAllSocials').then(response => {
        console.log(response);
        console.log(response.data);
    });
};