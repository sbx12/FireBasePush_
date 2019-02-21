'use-strict'

const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp(functions.config().firebase);

exports.sendNotification = functions.firestore.document("Users/{user_id}/Notification/{notification_id}").onWrite(event => {
	const user_id = event.params.user_id;
	const notification_id = event.params.notification_id;
	
	return admin.firestore().collection("Users").doc(user_id).collection("Notifications").doc(notification_id).get()
	.then(queryResult => {
		const from_user_id = queryResult.data().from;
		const from_message = queryResult.data().message;
		
		const from_data = admin.firestore().collection("Users").doc(from_user_id).get();
		const to_data = admin.firestore().collection("Users").doc(user_id).get();
		
		
		return Promise.all([from_data, to_data])
		.then(result => {
			const from_name = result[0].data().name;
			const to_name = result[1].data().name;
			const token_id = result[1].data().token_id;
			
			const payload = {
				notification: {
					title : "Notification From : " + from_name,
					body : from_message,
					icon : "default",
					click_action : "in.tvac.sbx.firebasepush.TARGETNOTIFICATION"
				},
				data: {
					message : from_message,
					from_id : from_id
				}
			};
			return admin.messaging().sendToDevice(token_id, payload);
		});
	});
});
// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//  response.send("Hello from Firebase!");
// });
