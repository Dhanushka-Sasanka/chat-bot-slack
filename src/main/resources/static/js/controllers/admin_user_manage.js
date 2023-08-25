//------------------------getAllUser-------------------------------------


function loadAllUsers() {
    $('#userTable').empty();

    $.ajax({
        type: "GET",
        url: baseURLAPI + 'user_details',
        async: true,
        dataType: "json",
        success: (response) => {
            console.log(response);
            for (let i in response) {
                let user = response[i];
                let userRoleString = "";

                let userID = user['id'];
                let userEmail = user['email'];
                let userName = user['name'];
                // let date = user[3];
                let userUserName = user['username'];
                // let startTime = user[5];

                if (user['roles'] !== undefined) {
                    let userRoles = user['roles'];
                    console.log(userRoles);
                    for (let role in userRoles) {
                        let userElement = userRoles[role];
                        console.log(userElement);
                        if (userRoles.length === 1) {
                            userRoleString = userRoleString.concat(userElement['name'] , " ");
                        } else {
                            userRoleString = userRoleString.concat(userElement['name'], ",");
                        }
                    }
                }


                let tableRow = "<tr>" +
                    "<td class='text-center text-primary'>" + userID + "</td>" +
                    "<td class='text-center'>" + userEmail + "</td>" +
                    "<td class='text-center '>" + userName + "</td>" +
                    "<td class='text-center text-danger'>" + userUserName + "</td>" +
                    "<td class='text-center text-danger'>" + userRoleString + "</td>" +
                    " <td><button>View</button></td>" +
                    // "<td class='text-center text-success'>" + time + "</td>" +
                    // "<td class='text-center text-success'>" + startTime + "</td>"+
                    "</tr>";

                $('#userTable').append(tableRow);
            }
        }
        , error: (error) => {
            console.log(error);
        }
    });
}

loadAllUsers();
