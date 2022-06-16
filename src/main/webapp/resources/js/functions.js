function deleteStudents() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')

    if (checkedCheckboxs.length == 0) {
        alert("Please check Student");
        return;


    }

    var ids = "";
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + " ";

    }


    document.getElementById("idsHiddenDelete").value = ids;
    document.getElementById("deleteForm").submit();


}

function modifyStudents() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')

    if (checkedCheckboxs.length == 0) {
        alert("Please check student");
        return;
    }


    if (checkedCheckboxs.length > 1) {
        alert("Please check only one student");
        return;
    }

    var id = checkedCheckboxs[0].value

    document.getElementById("idsHiddenModify").value = id;
    document.getElementById("modifyForm").submit();

}

function deleteDisciplines() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idDiscipline]:checked')

    if (checkedCheckboxs.length == 0) {
        alert("Please check Discipline");
        return;


    }

    var ids = "";
    for (var i = 0; i < checkedCheckboxs.length; i++) {
        ids = ids + checkedCheckboxs[i].value + " ";

    }


    document.getElementById("idsHiddenDelete").value = ids;
    document.getElementById("deleteForm").submit();


}

function modifyDiscipline() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idDiscipline]:checked')

    if (checkedCheckboxs.length == 0) {
        alert("Please check Discipline");
        return;
    }


    if (checkedCheckboxs.length > 1) {
        alert("Please check only one Discipline");
        return;
    }

    var id = checkedCheckboxs[0].value

    document.getElementById("idsHiddenModify").value = id;
    document.getElementById("modifyForm").submit();

}



function studentProgress() {
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')

    if (checkedCheckboxs.length == 0) {
        alert("Please check student");
        return;
    }


    if (checkedCheckboxs.length > 1) {
        alert("Please check only one student");
        return;
    }

    var id = checkedCheckboxs[0].value

    document.getElementById("idsHiddenProgress").value = id;
    document.getElementById("progressForm").submit();



}






