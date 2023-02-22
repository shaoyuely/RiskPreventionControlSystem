import Cookies from 'js-cookie'

const TokenKey = 'Current-Token'
const UserName = 'Current-User'

export function getToken() {
    return Cookies.get(TokenKey)
}

export function setToken(Token) {
    return Cookies.set(TokenKey, Token)
}

export function removeToken() {
    return Cookies.remove(TokenKey)
}

export function getUserName() {
    return Cookies.get(UserName)
}

export function setUserName(User) {
    return Cookies.set(UserName, User)
}

export function removeUserName() {
    return Cookies.remove(UserName)
}