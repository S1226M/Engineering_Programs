export type User = {
  id: number;
  name: string;
  email: string;
  role: string;
  status: string;
};

export const USERS: User[] = [
  { id: 1, name: "Smit Maru", email: "smit.maru@example.com", role: "Admin", status: "Active" },
  { id: 2, name: "Jainil Thummer", email: "jainil.thummer@example.com", role: "User", status: "Active" },
  { id: 3, name: "Balkrushna", email: "bala@example.com", role: "User", status: "Inactive" },
];

