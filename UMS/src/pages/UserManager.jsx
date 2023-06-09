import { UserList } from '../components';

import { useUserManager } from '../hooks';

export function UserManager() {
  const { users, deleteUserUI, updateUserUI } = useUserManager();

  return (
    <>
      <h1>Gestor de Usuarios</h1>
      <UserList users={ users } deleteUserUI={ deleteUserUI } updateUserUI={ updateUserUI } />
    </>
  );
};
