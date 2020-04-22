function viewDiv(className)
{
    document.getElementsByClassName(className.toString())[0].style.display = "block";
    document.getElementsByClassName(("backGround"))[0].style.display = "block";
}

function notViewDiv(className)
{
    document.getElementsByClassName(className)[0].style.display = "none";
    document.getElementsByClassName(("backGround"))[0].style.display = "none";
}

function delWorker(id)
{
    var x = new XMLHttpRequest();
    x.open("GET", "http://localhost:8080/delworker/" + id, true);
    x.onload = function ()
    {
        location.reload();
    }
    x.send(null);
}





