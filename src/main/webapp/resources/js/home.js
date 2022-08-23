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


const getGrandParentForm = (e) => {
    e.preventDefault();
    const grandParent = e.target.parentNode.parentNode;

    const formData = new FormData(grandParent);
    const inputObject = Object.fromEntries(formData);

    //console.log(inputObject);
    return inputObject;
};

const submitForm = (e) => {
    const formData = new FormData(e.target);
    const inputObject = Object.fromEntries(formData);

    return inputObject;
};

const handleFromClick = async (e) => {
    const formData = getGrandParentForm(e);
    const start_location_id = formData.from;
    try {
        const res = await httpRequest.get("routes", {params: {
                id: start_location_id
            }});
        renderStartLocationSelect(res.data);

        console.log(res);
    } catch (error) {
        console.log(error);
    }
};


const addComment = async (e) => {
    e.preventDefault();
    try {
        const formData = submitForm(e);
        const res = await httpRequest.post("comment", formData);
        if (res.data) {
            const bustripId = res.data.bustripId.id;
            let commentBox = document.getElementById(`commentBox-${bustripId}`);
            const comment = res.data;
            const avatar = comment.userId.avatar ? comment.userId.avatar : "https://bootdey.com/img/Content/avatar/avatar6.png";

            commentBox.innerHTML = `
            <li>
                <!-- begin timeline-body -->
                <div class="timeline-body">
                    <div class="timeline-header">
                        <span class="userimage">
                            <img src="${avatar}" alt="">
                        </span>
                        <span class="username"><a href="javascript:;">${comment.userId.username}</a> <small></small></span>
                        <!--<span class="pull-right text-muted">18 Views</span>-->
                    </div>
                    <div class="timeline-content">
                        <p>
                            ${comment.content}
                        </p>
                    </div>
                    <!-- end timeline-body -->
                <div/>
            </li>` + commentBox.innerHTML;
        }
        e.target.reset();


    } catch (error) {
        console.log(error);
    }
};


const select = $("#endLocationSelect").niceSelect();

function renderStartLocationSelect(locations) {
    const fragment = document.createDocumentFragment();


    const htmlOption = (location) => {
        var option = document.createElement('option');
        option.value = location.endLocationIdInt;
        option.text = location.endLocationName;
        return option;
    };

    for (const location of locations) {
        fragment.appendChild(htmlOption(location));
    }

    select.html(fragment);

    select.niceSelect("update");

}
