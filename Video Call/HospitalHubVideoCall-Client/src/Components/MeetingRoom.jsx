import React from "react";
import { MeetingProvider, useMeeting } from "@videosdk.live/react-sdk";

const MeetingView = ({ name }) => {
  const { join, participants } = useMeeting({
    onMeetingJoined: () => {
      console.log("Joined meeting");
    },
    onMeetingLeft: () => {
      console.log("Left meeting");
    },
  });

  React.useEffect(() => {
    join();
  }, []);

  return (
    <div>
      <h2>Meeting Room</h2>
      <p>Participant: {name}</p>
      <div>
        {Array.from(participants.keys()).map((participantId) => (
          <p key={participantId}>Participant ID: {participantId}</p>
        ))}
      </div>
    </div>
  );
};

export default function MeetingRoom({ meetingId, name }) {
  const token = sessionStorage.getItem("videosdkToken");

  return (
    <MeetingProvider
      config={{
        meetingId,
        micEnabled: true,
        webcamEnabled: true,
        name,
      }}
      token={token}
    >
      <MeetingView name={name} />
    </MeetingProvider>
  );
}
