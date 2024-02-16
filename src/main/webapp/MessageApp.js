function sendMessageToServlet() {
  var userId = document.querySelector('.userIdClass').value;
  var messageType = document.querySelector('.footerInput').value;
  var imageParse = document.querySelector('.VideoUpload').files[0];
  console.log(userId,messageType,imageParse.name);
  // Create FormData object
  var formData = new FormData();
  formData.append('userId', userId);
  formData.append('messageType', messageType);
  formData.append('ImageParse', imageParse);
  // Make a Fetch POST request
  fetch('http://localhost:8080/MessageApp/sendmessage', {
    method: 'POST',
    body: formData
  })
  .then(response => {
    // Handle the response here if needed
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.text();
  })
  .then(data => {
    console.log(data);
  })
  .catch(error => {
    console.error('Error:', error);
  });
}
const ShowMessagesPage = (id,name, imagePath) => {
  let RUserServletId=id;
  let formData = new FormData();
  formData.append('recieverId', RUserServletId);
  // Make a fetch request
  fetch('http://localhost:8080/MessageApp/rendermessages?id', {
    method: 'POST',
    body: formData
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.text();
  })
  .then(data => {
    //console.log(data);
  })
  .catch(error => {
    //console.error('There was a problem with the fetch operation:', error);
  });
};