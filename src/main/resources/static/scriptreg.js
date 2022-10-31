// // Get the modal
// var modal = document.getElementById('id01');
//
// // When the user clicks anywhere outside of the modal, close it
// window.onclick = function(event) {
//     if (event.target == modal) {
//         modal.style.display = "none";
//     }
// }


///**********************

const registrationForm = document.getElementById('registration-form');
registrationForm.addEventListener('submit', onRegisterHandler);

const BASE_URL = 'http://localhost:9787';

function onRegisterHandler(e){
    e.preventDefault();
    const form = e.target;
    const formData = new FormData(form);
    var object = {};
    formData.forEach(function(value, key){
        object[key] = value;
    });
    var json = JSON.stringify(object);
    console.log(json);

    send(json);
}

function send(json) {
    axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
    axios.post(BASE_URL+'/database',
        json,
        {
            headers: {
                "Content-Type": "application/json"
            }
        }
    )
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        })
        .then(function (other) {
        alert("Запрос был отправлен результат смотри выше")
    })
}

