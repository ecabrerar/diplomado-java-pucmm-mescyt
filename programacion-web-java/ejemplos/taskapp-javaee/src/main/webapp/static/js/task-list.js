$(function(){
	// Filter
	$("#filterButtons button").click(function(event){
        window.location.replace("/taskapp/tasks?filter=" + event.target.id);
	});
});