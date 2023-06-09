import PropTypes from 'prop-types';

import { UserItem } from "./UserItem";

export function UserList( { users, deleteUserUI, updateUserUI } ) {
  return (
    <main className="main-list">
      { users.map( ( user ) => 
        <UserItem key={ user?.id } { ...user } deleteUserUI={ deleteUserUI } updateUserUI={ updateUserUI } /> ) 
      }
    </main>
  );
};

UserList.propTypes = {
  users: PropTypes.array.isRequired,
  deleteUserUI: PropTypes.func.isRequired,
  updateUserUI: PropTypes.func.isRequired
};
